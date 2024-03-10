type Fn<T> = () => Promise<T>

function promiseAll<T>(functions: Fn<T>[]): Promise<T[]> {
    return new Promise(async (res, rej) => {
        const resolved: any[] = Array(functions.length).fill(null);
        let resolvedCount: number = 0;
        functions.forEach(async (el, idx) => {
              try {
                const subResult = await el();
                resolved[idx] = subResult;
                resolvedCount++;
                if(resolvedCount === functions.length) {
                  res(resolved);
                }
              } catch(err) {
                rej(err);
              }
        });
    })
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */