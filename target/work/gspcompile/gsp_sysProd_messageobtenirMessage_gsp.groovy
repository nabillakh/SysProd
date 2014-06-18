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
expressionOut.print(message.auteur.nom)
printHtmlPart(4)
expressionOut.print(message.auteur.prenom)
})
invokeTag('link','g',11,['action':("show"),'controller':("Effectif"),'id':(message.auteur.id)],2)
printHtmlPart(5)
if(true && (message.kanban)) {
printHtmlPart(6)
createTagBody(3, {->
printHtmlPart(7)
expressionOut.print(message.kanban.nomKanban)
})
invokeTag('link','g',13,['action':("show"),'controller':("Kanban"),'id':(message.kanban.id)],3)
printHtmlPart(6)
}
printHtmlPart(8)
invokeTag('formatDate','g',15,['format':("dd-MM-yyyy hh:mm a"),'date':(message.date)],-1)
printHtmlPart(9)
expressionOut.print(message.message)
printHtmlPart(10)
}
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043415L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
