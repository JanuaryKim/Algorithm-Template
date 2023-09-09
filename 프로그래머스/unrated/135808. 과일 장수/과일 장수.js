function solution(k, m, score) {
    let result = 0;
    let sorted = score.sort();
    for(let i = score.length - m; i >= 0; i-=m){
        result += score[i] * m;
    }
    return result;
}