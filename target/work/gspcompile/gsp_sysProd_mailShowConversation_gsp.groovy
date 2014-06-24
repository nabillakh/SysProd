import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mailShowConversation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mail/ShowConversation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',6,[:],1)
printHtmlPart(4)
invokeTag('render','g',9,['template':("/menues/mainleft")],-1)
printHtmlPart(5)
createClosureForHtmlPart(6, 1)
invokeTag('link','g',38,['action':("create"),'controller':("mail"),'class':("btn medium btn-primary pull-right")],1)
printHtmlPart(7)
expressionOut.print(conversationInstance.lastmail.objet)
printHtmlPart(8)
invokeTag('set','g',44,['var':("rep"),'value':(" ${Monlastmail.recepteur.size()}")],-1)
printHtmlPart(9)
invokeTag('set','g',45,['var':("tous"),'value':(" ${1}")],-1)
printHtmlPart(10)
if(true && (rep != tous)) {
printHtmlPart(11)
}
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(13)
invokeTag('hiddenField','g',80,['name':("conversation"),'value':(conversationInstance.id)],-1)
printHtmlPart(14)
expressionOut.print(Monlastmail.author?.id)
printHtmlPart(15)
invokeTag('hiddenField','g',82,['name':("objet"),'value':(Monlastmail?.objet),'placeholder':("Objet..."),'style':("width: 100%; height: 20px;")],-1)
printHtmlPart(16)
expressionOut.print(Monlastmail?.message)
printHtmlPart(17)
invokeTag('submitButton','g',85,['name':("create"),'controller':("Mail"),'class':("btn medium btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(18)
})
invokeTag('form','g',87,['url':([action:'Relier',controller:'Mail'])],1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(13)
invokeTag('hiddenField','g',91,['name':("conversation"),'value':(conversationInstance.id)],-1)
printHtmlPart(20)
invokeTag('hiddenField','g',91,['name':("author"),'value':(conversationInstance.lastmail.author?.id)],-1)
printHtmlPart(14)
expressionOut.print(Monlastmail.recepteur.recepteur?.username)
printHtmlPart(21)
invokeTag('hiddenField','g',93,['name':("objet"),'value':(Monlastmail?.objet),'placeholder':("Objet..."),'style':("width: 100%; height: 20px;")],-1)
printHtmlPart(16)
expressionOut.print(Monlastmail?.message)
printHtmlPart(17)
invokeTag('submitButton','g',96,['name':("create"),'controller':("Mail"),'class':("btn medium btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(18)
})
invokeTag('form','g',98,['url':([action:'RelierALL',controller:'Mail'])],1)
printHtmlPart(22)
loop:{
int i = 0
for( ListmailInstance in (Listmail) ) {
printHtmlPart(23)
expressionOut.print(ListmailInstance.author.username)
printHtmlPart(24)
expressionOut.print(ListmailInstance.dateCreated)
printHtmlPart(25)
expressionOut.print(ListmailInstance.recepteur.recepteur.username)
printHtmlPart(26)
expressionOut.print(ListmailInstance.message)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
invokeTag('set','g',130,['var':("listcompteur"),'value':(1)],-1)
printHtmlPart(29)
createClosureForHtmlPart(30, 1)
invokeTag('listMessagerie','messagerie',143,[:],1)
printHtmlPart(31)
createTagBody(1, {->
printHtmlPart(32)
invokeTag('hiddenField','g',169,['name':("conversation"),'value':(conversationInstance.id)],-1)
printHtmlPart(33)
invokeTag('hiddenField','g',170,['name':("objet"),'value':(conversationInstance.lastmail?.objet),'placeholder':("Objet..."),'style':("width: 100%; height: 20px;")],-1)
printHtmlPart(34)
expressionOut.print(conversationInstance.lastmail.author?.id)
printHtmlPart(35)
expressionOut.print(conversationInstance.lastmail?.message)
printHtmlPart(36)
invokeTag('submitButton','g',174,['name':("create"),'controller':("Mail"),'class':("btn medium btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(32)
invokeTag('hiddenField','g',175,['name':("conversation"),'value':(conversationInstance.id)],-1)
printHtmlPart(37)
})
invokeTag('form','g',177,['url':([action:'Relier',controller:'Mail'])],1)
printHtmlPart(38)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043390L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
