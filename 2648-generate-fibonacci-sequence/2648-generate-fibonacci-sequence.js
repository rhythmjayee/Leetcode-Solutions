/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    this.a = 0;
    this.b = 1;
    yield this.a;
    yield this.b;
    
    while(true) {
        let x = this.a + this.b
        this.a = this.b
        this.b = x
        yield x
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */