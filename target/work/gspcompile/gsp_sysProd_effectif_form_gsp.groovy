import application.RH.Effectif
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_effectif_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/effectif/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'username', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("effectif.username.label"),'default':("Username")],-1)
printHtmlPart(2)
invokeTag('textField','g',10,['name':("username"),'required':(""),'value':(effectifInstance?.username)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'password', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("effectif.password.label"),'default':("Password")],-1)
printHtmlPart(2)
invokeTag('textField','g',19,['name':("password"),'required':(""),'value':(effectifInstance?.password)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'mailEffectif', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("effectif.mailEffectif.label"),'default':("Mail Effectif")],-1)
printHtmlPart(6)
invokeTag('field','g',28,['type':("email"),'name':("mailEffectif"),'value':(effectifInstance?.mailEffectif)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'nom', 'error'))
printHtmlPart(7)
invokeTag('message','g',34,['code':("effectif.nom.label"),'default':("Nom")],-1)
printHtmlPart(6)
invokeTag('textField','g',37,['name':("nom"),'value':(effectifInstance?.nom)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'prenom', 'error'))
printHtmlPart(8)
invokeTag('message','g',43,['code':("effectif.prenom.label"),'default':("Prenom")],-1)
printHtmlPart(6)
invokeTag('textField','g',46,['name':("prenom"),'value':(effectifInstance?.prenom)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'equipe', 'error'))
printHtmlPart(9)
invokeTag('message','g',52,['code':("effectif.equipe.label"),'default':("Equipe")],-1)
printHtmlPart(6)
invokeTag('select','g',55,['id':("equipe"),'name':("equipe.id"),'from':(application.RH.Equipe.list()),'optionKey':("id"),'value':(effectifInstance?.equipe?.id),'class':("many-to-one"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'accountExpired', 'error'))
printHtmlPart(10)
invokeTag('message','g',61,['code':("effectif.accountExpired.label"),'default':("Account Expired")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',64,['name':("accountExpired"),'value':(effectifInstance?.accountExpired)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'accountLocked', 'error'))
printHtmlPart(11)
invokeTag('message','g',70,['code':("effectif.accountLocked.label"),'default':("Account Locked")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',73,['name':("accountLocked"),'value':(effectifInstance?.accountLocked)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'enabled', 'error'))
printHtmlPart(12)
invokeTag('message','g',79,['code':("effectif.enabled.label"),'default':("Enabled")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',82,['name':("enabled"),'value':(effectifInstance?.enabled)],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: effectifInstance, field: 'passwordExpired', 'error'))
printHtmlPart(13)
invokeTag('message','g',88,['code':("effectif.passwordExpired.label"),'default':("Password Expired")],-1)
printHtmlPart(6)
invokeTag('checkBox','g',91,['name':("passwordExpired"),'value':(effectifInstance?.passwordExpired)],-1)
printHtmlPart(14)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043301L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
