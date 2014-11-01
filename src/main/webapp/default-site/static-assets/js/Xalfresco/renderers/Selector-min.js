define(["dojo/_base/declare","dijit/_WidgetBase","dijit/_TemplatedMixin","dijit/_OnDijitClickMixin","alfresco/documentlibrary/_AlfDocumentListTopicMixin","dojo/text!./templates/Selector.html","alfresco/core/Core","dojo/_base/lang","dojo/dom-class"],function(g,i,n,e,f,l,c,b,j){return g([i,n,e,f,c],{cssRequirements:[{cssFile:"./css/Selector.css"}],templateString:l,postMixInProperties:function m(){this.intialClass="unchecked";this.alfSubscribe(this.documentSelectionTopic,b.hitch(this,"onFileSelection"))},onFileSelection:function h(o){if(o!=null){if(o.value=="selectAll"){this.select()}else{if(o.value=="selectNone"){this.deselect()}else{if(o.value=="selectInvert"){this.onClick()}else{if(o.value=="selectFolders"&&this.currentItem&&this.currentItem.jsNode){if(this.currentItem.jsNode.isContainer){this.select()}else{this.deselect()}}else{if(o.value=="selectDocuments"&&this.currentItem&&this.currentItem.jsNode){if(this.currentItem.jsNode.isContainer){this.deselect()}else{this.select()}}}}}}}},select:function d(){j.add(this.selectorNode,"checked");j.remove(this.selectorNode,"unchecked");this.alfPublish(this.documentSelectedTopic,{value:this.currentItem})},deselect:function k(){j.remove(this.selectorNode,"checked");j.add(this.selectorNode,"unchecked");this.alfPublish(this.documentDeselectedTopic,{value:this.currentItem})},onClick:function a(){if(j.contains(this.selectorNode,"checked")){this.deselect()}else{this.select()}}})});