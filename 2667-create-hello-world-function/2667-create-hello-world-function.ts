function createHelloWorld() {
    
    return function(...args): string {
        const str : string = "Hello World";
        return str;
    };
};

/**
 * const f = createHelloWorld();
 * f(); // "Hello World"
 */