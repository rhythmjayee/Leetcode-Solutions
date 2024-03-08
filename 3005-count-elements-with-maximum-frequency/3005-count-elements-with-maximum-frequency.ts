function maxFrequencyElements(nums: number[]): number {
    const freq: {[key: number]: number} = {};
    let maxFreq: number = 0;
    let count: number = 0;
    nums.map((num: number) => {
        if(freq[num] === undefined) freq[num] = 0;
        freq[num]++;
        maxFreq = Math.max(maxFreq, freq[num]);
        return num;
    });
   
    for (const [key, value] of Object.entries(freq)) {
      if(value === maxFreq) count += value;
    }
    return count;
};