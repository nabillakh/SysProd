package application.communication

import org.joda.time.DateTime
import org.joda.time.Minutes
import application.RH.Effectif

class Event {
    
      
    
    String title
    String location
    String description

    Date startTime 
    Date endTime
    
    Effectif organisateur
    
    static hasMany = [participants : EventEffectif]
    
    static transients = ['durationMinutes', 'dureeHeures']


    static constraints = {
        title(nullable: false, blank: false)
        location(nullable: true, blank:  true)
        description(nullable: true, blank: true)
        startTime(nullable: false)
        endTime(required: true, nullable: false, validator: {val, obj -> val > obj.startTime} )    
        participants nullable:true   
        organisateur nullable:true
        
    }

    public int getDurationMinutes() {
        Minutes.minutesBetween(new DateTime(startTime), new DateTime(endTime)).minutes
    }
    public Float getDureeHeures() {
        durationMinutes / 60
    }
    
    
   
    def beforeInsert = {    
        
        }
        
    
    static mappedBy = [participants : 'event']
    
    

}