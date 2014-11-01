define(["dojo/_base/declare","dijit/form/FilteringSelect","alfresco/core/Core","dojo/store/JsonRest","dojo/text!./templates/UserItem.html","dojo/_base/lang","dojo/_base/array","dojo/string","dojo/dom-class","alfresco/users/SingleUserSelectMenu"],function(h,d,c,e,m,b,k,l,o,g){return h([d,c],{cssRequirements:[{cssFile:"./css/SingleUserSelect.css"}],dropDownClass:g,postMixInProperties:function i(){if(this.store==null){this.store=new e({target:this.getRestUrl()})}this.inherited(arguments)},getRestUrl:function f(){return Alfresco.constants.PROXY_URI+"api/people"},postCreate:function p(){o.add(this.domNode,"alfresco-users-SingleUserSelect");this.inherited(arguments)},labelFunc:function(r,q){return r.firstName+" "+r.lastName},_getMenuLabelFromItem:function a(r){var q=this.inherited(arguments);q.html=true;var s=l.substitute(m,{avatarUrl:(r.avatar?Alfresco.constants.PROXY_URI+r.avatar:Alfresco.constants.URL_RESCONTEXT+"components/images/no-user-photo-64.png"),name:q.label,email:r.email});q.label=s;return q},_openResultList:function j(s,t,r){var q=s.people;k.forEach(q,b.hitch(this,"generateFilterAttr"));this.inherited(arguments,[q,t,r])},generateFilterAttr:function n(r,q){r.filter=r.firstName+" "+r.lastName}})});