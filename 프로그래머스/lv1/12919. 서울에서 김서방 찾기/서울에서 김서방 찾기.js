function solution(seoul) {
    
    let result = 0;
    seoul.filter((name,index) => {
        if(name === "Kim")
            result = index;
    })
    return `김서방은 ${result}에 있다`;
}