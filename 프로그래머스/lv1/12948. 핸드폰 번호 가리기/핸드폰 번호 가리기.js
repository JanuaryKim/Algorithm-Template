function solution(phone_number) {
    
    let result = "";
    
    for(let i = 1; i <= phone_number.length - 4; i++){
        result += "*";
    }
    return result + phone_number.substring(phone_number.length - 4, phone_number.length);
}