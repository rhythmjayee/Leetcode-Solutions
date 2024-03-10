type Obj = {[key: number]: number};
const reducerhelper = (nums: number[]): Obj => {
    let map1: Obj  = nums.reduce((acc: Obj, num: number) => {
        if(!acc[num]) acc[num] = 0;
        acc[num]++;
        return acc;
    }, {}); 
    return map1;
}
function intersection(nums1: number[], nums2: number[]): number[] {
    const ans: number[] = [];
    let map1: Obj  = reducerhelper(nums1);
    let map2: Obj  = reducerhelper(nums2);
    
    for(let [key, val] of Object.entries(map1)) {
        if(map2[key]) ans.push(Number(key));
    }
    return ans;
};