import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_menues_mainleft_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/menues/_mainleft.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createClosureForHtmlPart(1, 1)
invokeTag('link','g',25,['action':("show"),'controller':("Effectif"),'id':(sec.loggedInUserInfo(field:"id")),'class':("btn btn-inverse btn-small")],1)
printHtmlPart(2)
invokeTag('set','g',27,['var':("affichage"),'value':(1)],-1)
printHtmlPart(3)
createClosureForHtmlPart(4, 1)
invokeTag('miniMessagerie','messagerie',33,[:],1)
printHtmlPart(5)
invokeTag('set','g',35,['var':("affichageKanban"),'value':(1)],-1)
printHtmlPart(6)
createClosureForHtmlPart(7, 1)
invokeTag('kanbanmini','kanbans',40,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
invokeTag('username','sec',82,[:],-1)
})
invokeTag('ifLoggedIn','sec',82,[:],2)
})
invokeTag('link','g',82,['action':("show"),'controller':("Effectif"),'id':(sec.loggedInUserInfo(field:"id"))],1)
printHtmlPart(10)
createClosureForHtmlPart(11, 1)
invokeTag('link','g',83,['action':("edit"),'controller':("Effectif"),'id':(sec.loggedInUserInfo(field:"id"))],1)
printHtmlPart(12)
createClosureForHtmlPart(13, 1)
invokeTag('link','g',97,['action':("index"),'controller':("Login")],1)
printHtmlPart(14)
createClosureForHtmlPart(15, 1)
invokeTag('link','g',101,['controller':("effectif"),'action':("show"),'id':(sec.loggedInUserInfo(field:"id"))],1)
printHtmlPart(16)
createTagBody(1, {->
printHtmlPart(17)
createClosureForHtmlPart(18, 2)
invokeTag('link','g',105,['action':("index"),'controller':("Logout")],2)
printHtmlPart(19)
})
invokeTag('ifLoggedIn','sec',106,[:],1)
printHtmlPart(20)
createTagBody(1, {->
printHtmlPart(17)
createClosureForHtmlPart(21, 2)
invokeTag('link','g',108,['action':("index"),'controller':("Login")],2)
printHtmlPart(19)
})
invokeTag('ifNotLoggedIn','sec',109,[:],1)
printHtmlPart(22)
createClosureForHtmlPart(23, 1)
invokeTag('link','g',116,['action':("index"),'controller':("mail")],1)
printHtmlPart(24)
createClosureForHtmlPart(25, 1)
invokeTag('link','g',123,['controller':("kanban"),'action':("obtenirKanbanEffectif"),'id':(sec.loggedInUserInfo(field:"id"))],1)
printHtmlPart(26)
createClosureForHtmlPart(27, 1)
invokeTag('link','g',126,['action':("index"),'controller':("kanban")],1)
printHtmlPart(28)
createClosureForHtmlPart(29, 1)
invokeTag('link','g',129,['action':("feuilleImputation"),'controller':("imputation")],1)
printHtmlPart(30)
createClosureForHtmlPart(31, 1)
invokeTag('link','g',138,['controller':("effectif"),'action':("indicateurEffectif"),'id':(sec.loggedInUserInfo(field:"id"))],1)
printHtmlPart(16)
createClosureForHtmlPart(32, 1)
invokeTag('link','g',141,['action':("index"),'controller':("pdp")],1)
printHtmlPart(26)
createClosureForHtmlPart(33, 1)
invokeTag('link','g',144,['action':("index"),'controller':("pic")],1)
printHtmlPart(34)
createClosureForHtmlPart(35, 1)
invokeTag('link','g',149,['action':("index"),'controller':("event")],1)
printHtmlPart(36)
createClosureForHtmlPart(37, 1)
invokeTag('link','g',158,['action':("ressource"),'controller':("administration")],1)
printHtmlPart(38)
createClosureForHtmlPart(39, 1)
invokeTag('link','g',161,['action':("activite"),'controller':("administration")],1)
printHtmlPart(40)
invokeTag('set','g',174,['var':("calcul"),'value':(1)],-1)
printHtmlPart(41)
createClosureForHtmlPart(42, 1)
invokeTag('gaucheMessagerie','messagerie',180,[:],1)
printHtmlPart(43)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401896913762L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}