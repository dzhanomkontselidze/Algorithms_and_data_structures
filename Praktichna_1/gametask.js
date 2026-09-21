const MAX_SLOTS = 10;
// ініціалізація інвентарю
let inventory = Array(MAX_SLOTS).fill("Empty");
function addItem(inv, item) {
    const emptyIndex = inv.indexOf("Empty");
    if (emptyIndex !== -1) {
        inv[emptyIndex] = item;
        console.log(` Додано '${item}' у слот ${emptyIndex}`);
        return true;
    }
    console.log(`Помилка: Інвентар переповнений '${item}'`);
    return false;
}

function removeItem(inv, item) {
    const itemIndex = inv.indexOf(item);
    if (itemIndex !== -1) {
        inv[itemIndex] = "Empty";
        console.log(`Видалено '${item}' зі слота ${itemIndex}`);
        return true;
    }
    console.log(`Предмет '${item}' відсутній в інвентарі`);
    return false;
}

function compactInventory(inv) {
    let writeIndex = 0;
    for (let readIndex = 0; readIndex < inv.length; readIndex++) {
        if (inv[readIndex] !== "Empty") {
            if (writeIndex !== readIndex) {
                inv[writeIndex] = inv[readIndex];
                inv[readIndex] = "Empty";
            }
            writeIndex++;
        }
    }
    console.log("Інвентар успішно ущільнено");
}

}

addItem(inventory, "Revive Mint");
addItem(inventory, "CD Bagel");
addItem(inventory, "Glowshard");
addItem(inventory, "Thorn Ring");
addItem(inventory, "Justice Axe");
console.log("\nПочатковий інвентар:", inventory);

removeItem(inventory, "Revive Mint");
console.log("Після видалення Revive Mint:", inventory);

compactInventory(inventory);
console.log("Після ущільнення:", inventory);


addItem(inventory, "Black Shard");
console.log("Фінальний стан інвентарю:", inventory)
