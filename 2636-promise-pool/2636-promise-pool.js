var promisePool = async function(functions, n) {
    async function evaluateNext() {
        if (functions.length === 0) return;
        const fn = functions.shift();
        await fn();//wait for fn to get complete
        await evaluateNext();//try for other functions if any recursivly
    }
    //On n functions "evaluateNext" will get applied so that they can run parallely
    const nPromises = Array(n).fill().map(evaluateNext);
    await Promise.all(nPromises);
};