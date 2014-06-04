package application.communication

class Conversation {
    
    
    Mail lastmail 
    static hasMany = [mails:Mail] 
    Date lastDate = new Date()
    
    
    static constraints = {
        mails nullable : true
        lastmail nullable : true
    }
    
    
    def beforeInsert = {
    }
    
    def beforeUpdate = {
    }
   static mappedBy = [mails : 'conversation'] 
    
}
