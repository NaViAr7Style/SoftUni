function addressBookParser(input) {
    let addressDatabase = {};

    for (const entry of input) {
        let [name, address] = entry.split(":");
        addressDatabase[name] = address;
    }

    let addressBook = Object.entries(addressDatabase);

    addressBook.sort((a, b) => {
        nameA = a[0];
        nameB = b[0];
        return nameA.localeCompare(nameB);
    });

    for (const [name, address] of addressBook) {
        console.log(`${name} -> ${address}`);
    }
}