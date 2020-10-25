const firstObject = {
    firstKey: 1,
    objectKeyFirst: {
        string: 'hello',
        oddArray: [1, 3, 5],
        anotherObj: {
            key: 'Wat?'
        }
    },
    methodKey: function () {
        return this.objectKeyFirst.oddArray.length;
    }
}
const secondObject = {
    weirdArray: ['x'],
    objectKeyFirst: {
        oddArray: [5, 1, , 3]
    },
    methodKey: function () {
        return 3;
    }
}


console.log("element without changes: ");
console.log(firstObject);
console.log(secondObject);

console.log("function results without changes: ");
console.log(isObjectsEqual(firstObject, secondObject));

delete secondObject.weirdArray;

secondObject.firstKey = 1;

secondObject.objectKeyFirst.string = "hello";

secondObject.objectKeyFirst.oddArray = secondObject.objectKeyFirst.oddArray.filter(function (el) {
    return el != null;
  });

for(let i = 0 ; i < secondObject.objectKeyFirst.oddArray.length; i++){
    for(let j = 0 ; j < secondObject.objectKeyFirst.oddArray.length; j++){
        if (secondObject.objectKeyFirst.oddArray[ j ] > secondObject.objectKeyFirst.oddArray[j + 1]){
            secondObject.objectKeyFirst.oddArray[ j + 1 ] += secondObject.objectKeyFirst.oddArray[ j ];
            secondObject.objectKeyFirst.oddArray[ j ] = secondObject.objectKeyFirst.oddArray[ j + 1] - secondObject.objectKeyFirst.oddArray[j];
            secondObject.objectKeyFirst.oddArray[ j + 1] = secondObject.objectKeyFirst.oddArray[ j + 1 ] -secondObject.objectKeyFirst.oddArray[j];
        }
    }
}

secondObject.objectKeyFirst.anotherObj = {key:'Wat?'};

delete secondObject.methodKey;
secondObject.methodKey = function(){
        return this.objectKeyFirst.oddArray.length;
    }


console.log("objects after changes: ");
console.log(firstObject);
console.log(secondObject);

function isObjectsEqual(obj1, obj2) {
    if (typeof obj1 !== "object" || typeof obj2 !== "object") {
      return false;
    }
    if (obj1 === undefined || obj2 === undefined) {
      return false;
    }
    if (obj1 === null || obj2 === null) {
      return false;
    }
    let obj1Keys = Object.keys(obj1);
    let obj2Keys = Object.keys(obj2);
    if (obj1Keys.length !== obj2Keys.length) {
      return false;
    }
    for (let i = 0; i < obj1Keys.length; i++) {
      if (obj2Keys.includes(obj1Keys[i]) === false) {
        return false;
      }
    }
    for (let i = 0; i < obj1Keys.length; i++) {
      if (typeof(obj1[obj1Keys[i]]) === "object") {
        return isObjectsEqual(obj1[obj1Keys[i]], obj2[obj1Keys[i]]);
      }
      if (obj1[obj1Keys[i]] !== obj2[obj1Keys[i]]) {
        if (obj2[obj1Keys[i]].includes(obj1[obj1Keys[i]]) === false) {
            return false;
          }
      }
    }
    return true;
  }


console.log("result of fucntion: ")
console.log(isObjectsEqual(firstObject, secondObject));