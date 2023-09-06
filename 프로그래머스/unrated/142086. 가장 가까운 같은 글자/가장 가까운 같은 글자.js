function solution(s) {
    let answer = [];
    let st = [];
    for(let i = 0; i < s.length; i++){
        
        const c = s[i];
        
        if(st.includes(c)){
            answer.push(i - st.lastIndexOf(c));
        }
        else{
            answer.push(-1);
        }
        
        st.push(c);
    }
    
    return answer;
}