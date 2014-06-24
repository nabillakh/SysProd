import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_mailEffectifshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/mailEffectif/show.gsp" }
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
invokeTag('link','g',37,['action':("create"),'controller':("mail"),'class':("btn medium btn-primary pull-right")],1)
printHtmlPart(7)
expressionOut.print(mailEffectifInstance.mail?.objet)
printHtmlPart(8)
expressionOut.print(mailEffectifInstance.mail.author.username)
printHtmlPart(9)
expressionOut.print(mailEffectifInstance.mail.recepteur.recepteur.username)
printHtmlPart(10)
if(true && (mailEffectifInstance.archive == false)) {
createClosureForHtmlPart(11, 2)
invokeTag('link','g',66,['action':("Archiver"),'controller':("mailEffectif"),'onclick':("if(!window.confirm('Voulez-vous Supprimer')) return false;"),'id':(mailEffectifInstance.id),'class':("btn medium btn-primary pull-right")],2)
}
printHtmlPart(12)
if(true && ("${mailEffectifInstance.favoris == false} ${mailEffectifInstance.archive == false}")) {
createClosureForHtmlPart(13, 2)
invokeTag('link','g',67,['action':("Favoriser"),'controller':("mailEffectif"),'id':(mailEffectifInstance.id),'class':("btn medium btn-primary pull-right")],2)
}
printHtmlPart(14)
if(true && (mailEffectifInstance.archive == true)) {
createClosureForHtmlPart(15, 2)
invokeTag('link','g',68,['action':("delete"),'controller':("mailEffectif"),'onclick':("if(!window.confirm('Voulez-vous Supprimer')) return false;"),'id':(mailEffectifInstance.id),'class':("btn medium btn-primary pull-right")],2)
}
printHtmlPart(16)
expressionOut.print(mailEffectifInstance.mail?.message)
printHtmlPart(17)
createTagBody(1, {->
printHtmlPart(18)
invokeTag('hiddenField','g',75,['name':("conversation"),'value':(mailEffectifInstance.mail.conversation.id)],-1)
printHtmlPart(19)
expressionOut.print(mailEffectifInstance.mail.recepteur.recepteur?.id)
printHtmlPart(20)
invokeTag('hiddenField','g',77,['name':("objet"),'value':(mailEffectifInstance.mail?.objet),'placeholder':("Objet..."),'style':("width: 100%; height: 20px;")],-1)
printHtmlPart(21)
expressionOut.print(mailInstance?.message)
printHtmlPart(22)
invokeTag('submitButton','g',80,['name':("create"),'controller':("Mail"),'class':("btn medium btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(23)
})
invokeTag('form','g',82,['url':([action:'Relier',controller:'Mail'])],1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(18)
invokeTag('hiddenField','g',86,['name':("conversation"),'value':(mailEffectifInstance.mail.conversation.id)],-1)
printHtmlPart(19)
expressionOut.print(mailEffectifInstance.mail.recepteur.recepteur?.id)
printHtmlPart(20)
invokeTag('hiddenField','g',88,['name':("objet"),'value':(mailEffectifInstance.mail?.objet),'placeholder':("Objet..."),'style':("width: 100%; height: 20px;")],-1)
printHtmlPart(21)
expressionOut.print(mailInstance?.message)
printHtmlPart(22)
invokeTag('submitButton','g',91,['name':("create"),'controller':("Mail"),'class':("btn medium btn-primary"),'value':(message(code: 'default.button.create.label', default: 'Create'))],-1)
printHtmlPart(23)
})
invokeTag('form','g',93,['url':([action:'Relier',controller:'Mail'])],1)
printHtmlPart(25)
invokeTag('set','g',107,['var':("listcompteur"),'value':(1)],-1)
printHtmlPart(26)
createClosureForHtmlPart(27, 1)
invokeTag('listMessagerie','messagerie',109,[:],1)
printHtmlPart(28)
invokeTag('render','g',1,['template':("/menues/mainright")],-1)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043407L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
