var url="http://192.168.2.101:8888";

function indexDo(elem){
    var href=elem.href;
    var name=elem.innerText;

    var c=open(href);
    setTimeout(function() {
        console.log({name:name,url:href,content:content});
        var content=c.document.querySelector('.article-content').innerHTML
        c.close()
        $.ajax({
            url: url+'/addWSJ',
            data: {name:name,url:href,content:content},
            type: 'POST',
            async:false,
            success: function (response) {
            }
        });
    }, 18000);
}

var t=setInterval(function(){
    $.ajax({
        url: url+'/clearWSJ',
        type: 'POST',
        async:false,
        success: function (response) {
        }
    });

    
    var index=0;
    
    var elems=document.querySelectorAll('div[layout="LS-NO-IMAGE-SPOTLIGHT-SEVEN"] h3 a');

    indexDo(elems[index++]);
    
        
    var doTimes=setInterval(function() {
        if(index<elems.length){
            indexDo(elems[index++]);
        }else{
            clearInterval(doTimes);
        }
    }, 30000);
},60000*30);




        
            $.ajax({
                url: url+'/addWSJ',
                method: "GET",
                data: {name:"name",url:"url",content:"content"},
                contentType: "text/plain",
                success: (function (msg) {
                    var mode = getModeByFileExtension(currentFile);
                    editor.getSession().setMode(mode);
                    editor.setValue(msg);
                })
            })


