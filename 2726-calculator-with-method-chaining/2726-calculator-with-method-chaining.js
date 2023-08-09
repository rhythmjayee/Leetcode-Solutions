class Calculator {
  
  /** 
   * @param {number} value
   */
  constructor(value) {
    this.a = Number(value)
    this.err = null
  }

  /** 
   * @param {number} value
   * @return {Calculator}
   */
  add(value){
    this.a += Number(value)
      return this
  }

  /** 
   * @param {number} value
   * @return {Calculator}
   */
  subtract(value){
    this.a -= Number(value)
      return this
  }

  /** 
   * @param {number} value
   * @return {Calculator}
   */  
  multiply(value) {
    this.a *= Number(value)
      return this
  }

  /** 
   * @param {number} value
   * @return {Calculator}
   */
  divide(value) {
    if(Number(value) == 0) {
        this.err = new Error("Division by zero is not allowed")
    }
    this.a /= Number(value)
      return this
  }
  
  /** 
   * @param {number} value
   * @return {Calculator}
   */
  power(value) {
    this.a = Math.pow(this.a, Number(value))
      return this
  }
    
  /** 
   * @return {number}
   */
  getResult() {
    if(this.err !== null) return this.err.message
    return this.a
  }
}