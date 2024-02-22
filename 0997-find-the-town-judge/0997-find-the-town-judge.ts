function findJudge(n: number, trust: number[][]): number {
    const points: number[] = Array(n).fill(0);
    trust.map((person: number[]) => {
        points[person[0] - 1] -= 1;
        points[person[1] - 1] += 1;
    });
    for(let per = 0; per < n; per++) {
        if(points[per] === n - 1) return per + 1;
    }
    return -1;
};