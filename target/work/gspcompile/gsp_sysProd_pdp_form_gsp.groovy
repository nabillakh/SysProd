import application.pilotage.Pdp
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_sysProd_pdp_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/pdp/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: pdpInstance, field: 'dateVersion', 'error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("pdp.dateVersion.label"),'default':("Date Version")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',10,['name':("dateVersion"),'precision':("day"),'value':(pdpInstance?.dateVersion),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: pdpInstance, field: 'dateMaj', 'error'))
printHtmlPart(4)
invokeTag('message','g',16,['code':("pdp.dateMaj.label"),'default':("Date Maj")],-1)
printHtmlPart(2)
invokeTag('datePicker','g',19,['name':("dateMaj"),'precision':("day"),'value':(pdpInstance?.dateMaj),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: pdpInstance, field: 'uniteActivite', 'error'))
printHtmlPart(5)
invokeTag('message','g',25,['code':("pdp.uniteActivite.label"),'default':("Unite Activite")],-1)
printHtmlPart(2)
invokeTag('field','g',28,['name':("uniteActivite"),'value':(fieldValue(bean: pdpInstance, field: 'uniteActivite'))],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: pdpInstance, field: 'kanbansRealises', 'error'))
printHtmlPart(6)
invokeTag('message','g',34,['code':("pdp.kanbansRealises.label"),'default':("Kanbans Realises")],-1)
printHtmlPart(7)
for( k in (pdpInstance?.kanbansRealises) ) {
printHtmlPart(8)
createTagBody(2, {->
expressionOut.print(k?.encodeAsHTML())
})
invokeTag('link','g',40,['controller':("pdpKanban"),'action':("show"),'id':(k.id)],2)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(1, {->
expressionOut.print(message(code: 'default.add.label', args: [message(code: 'pdpKanban.label', default: 'PdpKanban')]))
})
invokeTag('link','g',43,['controller':("pdpKanban"),'action':("create"),'params':(['pdp.id': pdpInstance?.id])],1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: pdpInstance, field: 'mois', 'error'))
printHtmlPart(12)
invokeTag('message','g',52,['code':("pdp.mois.label"),'default':("Mois")],-1)
printHtmlPart(13)
invokeTag('field','g',55,['name':("mois"),'type':("number"),'value':(pdpInstance.mois),'required':("")],-1)
printHtmlPart(3)
expressionOut.print(hasErrors(bean: pdpInstance, field: 'picFamille', 'error'))
printHtmlPart(14)
invokeTag('message','g',61,['code':("pdp.picFamille.label"),'default':("Pic Famille")],-1)
printHtmlPart(13)
invokeTag('select','g',64,['id':("picFamille"),'name':("picFamille.id"),'from':(application.pilotage.PicFamille.list()),'optionKey':("id"),'required':(""),'value':(pdpInstance?.picFamille?.id),'class':("many-to-one")],-1)
printHtmlPart(15)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1401189043423L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
