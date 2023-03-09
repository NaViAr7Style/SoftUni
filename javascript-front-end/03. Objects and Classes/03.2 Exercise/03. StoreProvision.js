function storeProvision(stock, ordereredProducts) {
    let combinedProducts = [...stock, ...ordereredProducts];
    let store = {};

    for (let i = 0; i < combinedProducts.length; i += 2) {
        let product = combinedProducts[i];
        let quantity = Number(combinedProducts[i + 1]);

        if (!store.hasOwnProperty(product)) {
            store[product] = 0;
        }
        
        store[product] += quantity;
    }

    for (const key in store) {
        console.log(`${key} -> ${store[key]}`);
    }
}