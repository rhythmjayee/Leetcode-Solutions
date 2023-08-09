class Calculator {
  
  /** 
   * @param {number} value
   */
  constructor(value) {
    this.a = Number(value)
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
        throw "Division by zero is not allowed"
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
    return this.a
  }
}