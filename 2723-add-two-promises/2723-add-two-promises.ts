type P = Promise<number>

async function addTwoPromises(promise1: P, promise2: P): P {
    const res: number[] = await Promise.all([promise1, promise2]);
    return res.reduce((acc, num) => acc += num, 0);
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */