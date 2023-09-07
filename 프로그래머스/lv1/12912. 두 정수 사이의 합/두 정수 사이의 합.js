function solution(a, b) {
    
    let sum = 0;
    const max = Math.max(a,b);
    const min = Math.min(a,b);
    
    for(let i = min; i <= max; i++){
        sum += i;
    }
    return sum;
}