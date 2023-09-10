function solution(ingredient) {
    
    let result = 0;
    let st = [...ingredient];
    let idx = 0;
    
    for(let i of ingredient){
        st[idx++] = i;
        if(idx >= 4 && 
          st[idx - 4] == 1 && st[idx - 3] == 2 && st[idx - 2] == 3 && st[idx - 1] == 1) {
            result++;
            idx -= 4;
        }
    }
    
    return result;
}