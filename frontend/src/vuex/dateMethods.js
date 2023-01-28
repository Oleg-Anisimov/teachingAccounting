export const methods = {
    methods: {
        STRING_TO_DATE(string){
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
            for(var i = 0; i < dataToSplit.length; i++){
                if(dataToSplit[i].toString().length ===1){
                    dataToSplit[i] = "0" + dataToSplit[i]
                }
            }
            dataToSplit = dataToSplit.join('-')
            console.log(dataToSplit)
            return dataToSplit
        }
    }
}