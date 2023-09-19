function solution(s){
    s=s.toUpperCase();
    
    let pCtn = 0;
    let yCtn = 0;
    for(let i = 0; i < s.length; i++){
        console.log(s[i]);
        if(s[i] == 'P')
            pCtn++;
        else if(s[i] == 'Y')
            yCtn++;
    }
    if(pCtn === yCtn)
        return true;
    else
        return false;
}