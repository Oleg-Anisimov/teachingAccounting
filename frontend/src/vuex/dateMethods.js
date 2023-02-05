export const methods = {
    methods: {
        STRING_TO_DATE(string){
            console.log(string)
            var dataToSplit = ""
            dataToSplit = string.split('-')
            for(var i = 0; i < dataToSplit.length; i++){
                dataToSplit[i] = parseInt(dataToSplit[i])
            }
            return dataToSplit;
        },
        DATE_TO_STRING(date){
            var dataToSplit = []
            dataToSplit = date
            if(dataToSplit === undefined || dataToSplit === null){
                return "";
            }
            console.log(date)
            for(var i = 0; i < dataToSplit.length; i++){
                if(dataToSplit[i].toString().length ===1){
                    dataToSplit[i] = "0" + dataToSplit[i]
                }
            }
            dataToSplit = dataToSplit.join('-')
            return dataToSplit
        }
    }
}