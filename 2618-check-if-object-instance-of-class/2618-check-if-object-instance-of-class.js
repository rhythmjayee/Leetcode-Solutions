/**
 * @param {Object} object
 * @param {Function} classFunction
 * @return {boolean}
 */
var checkIfInstanceOf = function isInstanceOf(obj, classOrSuperclass) {
  if (obj == null || obj == undefined || typeof classOrSuperclass !== 'function') {
    return false
  }

  let currentPrototype = Object.getPrototypeOf(obj);
  while (currentPrototype !== null) {
    if (currentPrototype.constructor === classOrSuperclass) {
      return true;
    }
    currentPrototype = Object.getPrototypeOf(currentPrototype);
  }

  return false;
}


/**
 * checkIfInstanceOf(new Date(), Date); // true
 */