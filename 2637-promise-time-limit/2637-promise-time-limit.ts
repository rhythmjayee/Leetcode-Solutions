type Fn = (...params: any[]) => Promise<any>;

function timeLimit(fn: Fn, t: number): Fn {
    return async function(...args): Promise<any> {
        const timedPromise: Promise<any> = 
                  new Promise((res, rej) => setTimeout(() => res("TimeOut"), t));
        const res: any = await Promise.race([timedPromise, fn(...args)]);
        return new Promise((resolve, reject) => {
            if(res === "TimeOut") reject("Time Limit Exceeded");
            else resolve(res);
        });
    }
};

/**
 * const limited = timeLimit((t) => new Promise(res => setTimeout(res, t)), 100);
 * limited(150).catch(console.log) // "Time Limit Exceeded" at t=100ms
 */