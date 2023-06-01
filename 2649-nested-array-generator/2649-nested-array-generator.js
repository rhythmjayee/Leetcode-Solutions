var inorderTraversal = function*(arr) {
    if (Array.isArray(arr)) {
        for (let a of arr) {
            yield* inorderTraversal(a);
        }
    } else {
        yield arr;
    }
};