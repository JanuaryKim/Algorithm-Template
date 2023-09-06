function solution(keymap, targets) {
    let result = [];

    for(let i = 0; i < targets.length; i++){
        const tStr = targets[i];
        let keyCtn = 0;
        for(let j = 0; j < tStr.length; j++){
            const curC = tStr[j];

            let tempCtn = Number.MAX_SAFE_INTEGER;
            for(let key in keymap){
                const idx = keymap[key].indexOf(curC);
                if(idx != -1 && idx < tempCtn)
                    tempCtn = idx + 1;
            }

            if(tempCtn == Number.MAX_SAFE_INTEGER) {
                keyCtn = -1;
                break;
            }

            keyCtn += tempCtn;
        }
        result.push(keyCtn);
    }

    return result;
}