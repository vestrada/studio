CodeMirror.defineMode("groovy",function(c,e){function k(s){var q={},r=s.split(" ");
for(var p=0;
p<r.length;
++p){q[r[p]]=true
}return q
}var f=k("abstract as assert boolean break byte case catch char class const continue def default do double else enum extends final finally float for goto if implements import in instanceof int interface long native new package private protected public return short static strictfp super switch synchronized threadsafe throw throws transient try void volatile while");
var b=k("catch class do else finally for if switch try while enum interface def");
var g=k("null true false this");
var l;
function d(s,q){var p=s.next();
if(p=='"'||p=="'"){return m(p,s,q)
}if(/[\[\]{}\(\),;\:\.]/.test(p)){l=p;
return null
}if(/\d/.test(p)){s.eatWhile(/[\w\.]/);
if(s.eat(/eE/)){s.eat(/\+\-/);
s.eatWhile(/\d/)
}return"number"
}if(p=="/"){if(s.eat("*")){q.tokenize.push(i);
return i(s,q)
}if(s.eat("/")){s.skipToEnd();
return"comment"
}if(a(q.lastToken)){return m(p,s,q)
}}if(p=="-"&&s.eat(">")){l="->";
return null
}if(/[+\-*&%=<>!?|\/~]/.test(p)){s.eatWhile(/[+\-*&%=<>|~]/);
return"operator"
}s.eatWhile(/[\w\$_]/);
if(p=="@"){s.eatWhile(/[\w\$_\.]/);
return"meta"
}if(q.lastToken=="."){return"property"
}if(s.eat(":")){l="proplabel";
return"property"
}var r=s.current();
if(g.propertyIsEnumerable(r)){return"atom"
}if(f.propertyIsEnumerable(r)){if(b.propertyIsEnumerable(r)){l="newstatement"
}return"keyword"
}return"variable"
}d.isBase=true;
function m(p,u,s){var r=false;
if(p!="/"&&u.eat(p)){if(u.eat(p)){r=true
}else{return"string"
}}function q(y,w){var x=false,v,t=!r;
while((v=y.next())!=null){if(v==p&&!x){if(!r){break
}if(y.match(p+p)){t=true;
break
}}if(p=='"'&&v=="$"&&!x&&y.eat("{")){w.tokenize.push(o());
return"string"
}x=!x&&v=="\\"
}if(t){w.tokenize.pop()
}return"string"
}s.tokenize.push(q);
return q(u,s)
}function o(){var q=1;
function p(s,r){if(s.peek()=="}"){q--;
if(q==0){r.tokenize.pop();
return r.tokenize[r.tokenize.length-1](s,r)
}}else{if(s.peek()=="{"){q++
}}return d(s,r)
}p.isBase=true;
return p
}function i(s,r){var p=false,q;
while(q=s.next()){if(q=="/"&&p){r.tokenize.pop();
break
}p=(q=="*")
}return"comment"
}function a(p){return !p||p=="operator"||p=="->"||/[\.\[\{\(,;:]/.test(p)||p=="newstatement"||p=="keyword"||p=="proplabel"
}function n(t,q,p,s,r){this.indented=t;
this.column=q;
this.type=p;
this.align=s;
this.prev=r
}function h(r,p,q){return r.context=new n(r.indented,p,q,null,r.context)
}function j(q){var p=q.context.type;
if(p==")"||p=="]"||p=="}"){q.indented=q.context.indented
}return q.context=q.context.prev
}return{startState:function(p){return{tokenize:[d],context:new n((p||0)-c.indentUnit,0,"top",false),indented:0,startOfLine:true,lastToken:null}
},token:function(s,r){var p=r.context;
if(s.sol()){if(p.align==null){p.align=false
}r.indented=s.indentation();
r.startOfLine=true;
if(p.type=="statement"&&!a(r.lastToken)){j(r);
p=r.context
}}if(s.eatSpace()){return null
}l=null;
var q=r.tokenize[r.tokenize.length-1](s,r);
if(q=="comment"){return q
}if(p.align==null){p.align=true
}if((l==";"||l==":")&&p.type=="statement"){j(r)
}else{if(l=="->"&&p.type=="statement"&&p.prev.type=="}"){j(r);
r.context.align=false
}else{if(l=="{"){h(r,s.column(),"}")
}else{if(l=="["){h(r,s.column(),"]")
}else{if(l=="("){h(r,s.column(),")")
}else{if(l=="}"){while(p.type=="statement"){p=j(r)
}if(p.type=="}"){p=j(r)
}while(p.type=="statement"){p=j(r)
}}else{if(l==p.type){j(r)
}else{if(p.type=="}"||p.type=="top"||(p.type=="statement"&&l=="newstatement")){h(r,s.column(),"statement")
}}}}}}}}r.startOfLine=false;
r.lastToken=l||q;
return q
},indent:function(t,q){if(!t.tokenize[t.tokenize.length-1].isBase){return 0
}var s=q&&q.charAt(0),p=t.context;
if(p.type=="statement"&&!a(t.lastToken)){p=p.prev
}var r=s==p.type;
if(p.type=="statement"){return p.indented+(s=="{"?0:c.indentUnit)
}else{if(p.align){return p.column+(r?0:1)
}else{return p.indented+(r?0:c.indentUnit)
}}},electricChars:"{}"}
});
CodeMirror.defineMIME("text/x-groovy","groovy");