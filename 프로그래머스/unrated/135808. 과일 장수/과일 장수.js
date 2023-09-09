function solution(k, m, score) {
    let result = 0;
    let sorted = score.sort();
    let j = m;
    for(let i = score.length - 1; i >= 0; i--){
        if(j == 1) {
            result += score[i] * m;
            j = m;
        }
        else
            j--;
    }
    return result;
}