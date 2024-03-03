type ToBeOrNotToBe = {
    toBe: (val: any) => boolean;
    notToBe: (val: any) => boolean;
};

function expect(val: any): ToBeOrNotToBe {
    const obj : ToBeOrNotToBe = {
        toBe: (passed: any) : boolean => {
            if(passed !== val) throw new Error("Not Equal");
            return true;
        },
        notToBe: (passed: any) : boolean => {
            if(passed === val) throw new Error("Equal");
            return true;
        }
    }
    return obj;
};

/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */