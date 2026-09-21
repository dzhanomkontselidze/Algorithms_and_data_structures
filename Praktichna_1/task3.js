// допоміжний метод
function generateRandomArray(length, minValue, maxValue) {
    const array = [];
    for (let i = 0; i < length; i++) {
        const randomNum = Math.floor(Math.random() * (maxValue - minValue + 1)) + minValue;
        array.push(randomNum);
    }
    return array;
}

// завдання 1
function task1_EvenInRange(arr, startIndex, endIndex) {
    let count = 0;
    let sum = 0;


    // перевірка
    const start = Math.max(0, startIndex);
    const end = Math.min(arr.length - 1, endIndex);
    for (let i = start; i <= end; i++) {
        if (arr[i] % 2 === 0) {
            count++;
            sum += arr[i];
        }
    }
    return { count, sum };
}
// завдання 2
function task2_AverageAndGreater(arr) {
    if (arr.length === 0) return { avg: 0, greaterCount: 0 };
   
    const sum = arr.reduce((acc, val) => acc + val, 0);
    const avg = sum / arr.length;
    const greaterCount = arr.filter(x => x > avg).length;
   
    return { avg: Number(avg.toFixed(2)), greaterCount };
}
// завдання 3
function task3_PairwiseSum(arr1, arr2) {
    return arr1.map((val, i) => val + arr2[i]);
}

const arrayLength = 10;
const minVal = -10;
const maxVal = 10;
const startIndex = 2;
const endIndex = 7;

// генерація масиву
const myArray = generateRandomArray(arrayLength, minVal, maxVal);
const myArray2 = generateRandomArray(arrayLength, minVal, maxVal);

// діапазон масиву
const result = task1_EvenInRange(myArray, startIndex, endIndex);


console.log("Масив:", myArray);
console.log(`Аналіз діапазону індексів [${startIndex}..${endIndex}]:`);
console.log(`- Кількість парних елементів: ${result.count}`);
console.log(`- Сума парних елементів: ${result.sum}`);
console.log("- Середнє та більші елементи:", task2_AverageAndGreater(myArray));
console.log(" Попарна сума:", task3_PairwiseSum(myArray,myArray2));
