/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    let res = await Promise.all([promise1, promise2]);
    return new Promise((resolve, reject) => {
        let sum = res[0] + res[1]
        resolve(sum)
    })
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */