import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_messageobtenirMessageKanban_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/message/obtenirMessageKanban.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
for( message in (mesMessages) ) {
printHtmlPart(1)
if(true && (message.auteur == moi)) {
printHtmlPart(2)
}
else {
printHtmlPart(3)
}
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(message.auteur.nom)
printHtmlPart(6)
expressionOut.print(message.auteur.prenom)
})
invokeTag('link','g',13,['action':("show"),'controller':("Effectif"),'id':(message.auteur.id)],2)
printHtmlPart(7)
if(true && (message.kanban)) {
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
expressionOut.print(message.kanban.nomKanban)
})
invokeTag('link','g',15,['action':("show"),'controller':("Kanban"),'id':(message.kanban.id)],3)
printHtmlPart(8)
}
printHtmlPart(10)
invokeTag('formatDate','g',17,['format':("dd-MM-yyyy hh:mm a"),'date':(message.date)],-1)
printHtmlPart(11)
expressionOut.print(message.message)
printHtmlPart(12)
createClosureForHtmlPart(13, 2)
invokeTag('link','g',20,['action':("index"),'controller':("commentaire"),'class':("pull-right")],2)
printHtmlPart(14)
if(true && (message.commentaires)) {
printHtmlPart(15)
loop:{
int i = 0
for( commentaire in (message.commentaires) ) {
printHtmlPart(16)
expressionOut.print(commentaire.auteur.nom)
printHtmlPart(17)
invokeTag('formatDate','g',38,['format':("dd-MM-yyyy hh:mm a"),'date':(commentaire.date)],-1)
printHtmlPart(11)
expressionOut.print(commentaire.texte)
printHtmlPart(18)
i++
}
}
printHtmlPart(19)
}
printHtmlPart(20)
}
printHtmlPart(21)
invokeTag('remoteFunction','g',54,['controller':("message"),'action':("posterMessage"),'params':("\'message=\'+message"),'update':("temp")],-1)
printHtmlPart(22)
invokeTag('remoteFunction','g',63,['controller':("message"),'action':("obtenirMessage"),'update':("newsfeed")],-1)
printHtmlPart(23)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403593073205L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
