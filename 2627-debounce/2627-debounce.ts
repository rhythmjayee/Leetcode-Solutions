type F = (...args: number[]) => void

function debounce(fn: F, t: number): F {
    let timeoutHandler: any;
    let time: number = 0;
    return function(...args): void {
        if(time > Date.now()) {
            clearTimeout(timeoutHandler);
        }
        time = Date.now() + t;
        timeoutHandler = setTimeout(() => fn(...args), t);
    }
};

/**
 * const log = debounce(console.log, 100);
 * log('Hello'); // cancelled
 * log('Hello'); // cancelled
 * log('Hello'); // Logged at t=100ms
 */