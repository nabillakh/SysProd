import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_messageobtenirMessage_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/message/obtenirMessage.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
for( message in (mesMessages) ) {
printHtmlPart(0)
if(true && (message.auteur == moi)) {
printHtmlPart(1)
}
else {
printHtmlPart(2)
}
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(message.auteur.nom)
printHtmlPart(5)
expressionOut.print(message.auteur.prenom)
})
invokeTag('link','g',11,['action':("show"),'controller':("Effectif"),'id':(message.auteur.id)],2)
printHtmlPart(6)
if(true && (message.kanban)) {
printHtmlPart(7)
createTagBody(3, {->
printHtmlPart(8)
expressionOut.print(message.kanban.nomKanban)
})
invokeTag('link','g',13,['action':("show"),'controller':("Kanban"),'id':(message.kanban.id)],3)
printHtmlPart(7)
}
printHtmlPart(9)
invokeTag('formatDate','g',15,['format':("dd-MM-yyyy hh:mm a"),'date':(message.date)],-1)
printHtmlPart(10)
expressionOut.print(message.message)
printHtmlPart(11)
createClosureForHtmlPart(12, 2)
invokeTag('link','g',18,['action':("index"),'controller':("commentaire"),'class':("pull-right")],2)
printHtmlPart(13)
if(true && (message.commentaires)) {
printHtmlPart(14)
for( commentaire in (message.commentaires) ) {
printHtmlPart(15)
expressionOut.print(commentaire.auteur.nom)
printHtmlPart(16)
invokeTag('formatDate','g',38,['format':("dd-MM-yyyy hh:mm a"),'date':(commentaire.date)],-1)
printHtmlPart(10)
expressionOut.print(commentaire.texte)
printHtmlPart(17)
}
}
printHtmlPart(18)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1403189287603L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
