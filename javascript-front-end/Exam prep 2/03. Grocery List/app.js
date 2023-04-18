function solve() {
  const BASE_URL = "http://localhost:3030/jsonstore/grocery/";
  let updateId = "";

  const btnDOMSelectors = {
    addBtn: document.getElementById("add-product"),
    updateBtn: document.getElementById("update-product"),
    loadBtn: document.getElementById("load-product"),
  };

  const otherDOMSelectors = {
    tbody: document.getElementById("tbody"),
  };

  const inputDOMSelectors = {
    product: document.getElementById("product"),
    count: document.getElementById("count"),
    price: document.getElementById("price"),
  };

  btnDOMSelectors.loadBtn.addEventListener("click", loadAllProductsHandler);
  btnDOMSelectors.addBtn.addEventListener("click", addProductHandler);

  async function loadAllProductsHandler(event) {
    event?.preventDefault();
    otherDOMSelectors.tbody.innerHTML = "";

    const loadAllProductsRes = await fetch(BASE_URL);
    const data = await loadAllProductsRes.json();

    try {
      for (const item in data) {
        const { product, count, price, _id } = data[item];
        const tr = createElement("tr", otherDOMSelectors.tbody);
        createElement("td", tr, product, ["name"]);
        createElement("td", tr, count, ["count-product"]);
        createElement("td", tr, price, ["product-price"]);
        const btnTd = createElement("td", tr, "", ["btn"]);

        const updateItemBtn = createElement(
          "button",
          btnTd,
          "Update",
          ["update"],
          _id
        );
        updateItemBtn.addEventListener("click", updateProductHandler);

        const deleteItemBtn = createElement(
          "button",
          btnTd,
          "Delete",
          ["delete"],
          _id
        );
        deleteItemBtn.addEventListener("click", deleteProductHandler);
      }
    } catch (err) {
      console.log("Error");
    }
  }

  function addProductHandler(event) {
    event?.preventDefault();

    const allInputsHaveValue = Object.values(inputDOMSelectors).every(
      (input) => input.value !== ""
    );

    if (!allInputsHaveValue) {
      return;
    }

    const item = {
      product: `${inputDOMSelectors.product.value}`,
      count: `${inputDOMSelectors.count.value}`,
      price: `${inputDOMSelectors.price.value}`,
    };

    const httpHeaders = {
      method: "POST",
      body: JSON.stringify(item),
    };

    fetch(BASE_URL, httpHeaders)
      .then(() => {
        loadAllProductsHandler();
        Object.values(inputDOMSelectors).forEach((input) => (input.value = ""));
      })
      .catch((err) => {
        console.error(err);
      });
  }

  function updateProductHandler() {
    updateId = this.id;
    const divContainer = this.parentNode.parentNode;
    const productName = divContainer.children[0];
    const productCount = divContainer.children[1];
    const productPrice = divContainer.children[2];

    inputDOMSelectors.product.value = productName.textContent;
    inputDOMSelectors.count.value = productCount.textContent;
    inputDOMSelectors.price.value = productPrice.textContent;

    btnDOMSelectors.addBtn.disabled = true;
    btnDOMSelectors.updateBtn.disabled = false;
    btnDOMSelectors.updateBtn.addEventListener("click", patchProductHandler);
  }

  function patchProductHandler() {
    const updatedItem = {
      product: `${inputDOMSelectors.product.value}`,
      count: `${inputDOMSelectors.count.value}`,
      price: `${inputDOMSelectors.price.value}`,
    };

    const httpHeaders = {
      method: "PATCH",
      body: JSON.stringify(updatedItem),
    };

    fetch(`${BASE_URL}${updateId}`, httpHeaders)
      .then(() => {
        loadAllProductsHandler();
        Object.values(inputDOMSelectors).forEach((input) => (input.value = ""));
        btnDOMSelectors.addBtn.disabled = false;
        btnDOMSelectors.updateBtn.disabled = true;
      })
      .catch((err) => {
        console.error(err);
      });
  }

  function deleteProductHandler() {
    const productId = this.id;
    const httpHeaders = {
      method: "DELETE",
    };

    fetch(`${BASE_URL}${productId}`, httpHeaders)
      .then(() => loadAllProductsHandler())
      .catch((err) => {
        console.error(err);
      });
  }

  function createElement(
    type,
    parentNode,
    content,
    classes,
    id,
    attributes,
    useInnerHtml
  ) {
    const htmlElement = document.createElement(type);

    if (content && useInnerHtml) {
      htmlElement.innerHTML = content;
    } else {
      if (content && type !== "input") {
        htmlElement.textContent = content;
      }

      if (content && type === "input") {
        htmlElement.value = content;
      }
    }

    if (classes && classes.length > 0) {
      htmlElement.classList.add(...classes);
    }

    if (id) {
      htmlElement.id = id;
    }

    if (attributes) {
      for (const key in attributes) {
        htmlElement[key] = attributes[key];
      }
    }

    if (parentNode) {
      parentNode.appendChild(htmlElement);
    }

    return htmlElement;
  }
}

solve();
