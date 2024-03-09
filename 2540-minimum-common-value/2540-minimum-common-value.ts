function getCommon(nums1: number[], nums2: number[]): number {
    const n1: number = nums1.length;
    const n2: number = nums2.length;
    let p1: number = 0;
    let p2: number = 0;
    
    while(p1 < n1 && p2 < n2) {
        if(nums1[p1] === nums2[p2]) return nums1[p1];
        while(p1 < n1 && nums1[p1] < nums2[p2]) {
            p1++;
        }
        while(p2 < n2 && nums2[p2] < nums1[p1]) {
            p2++;
        }
    }
    return -1;
};