package test

class CareAssetTagLib {

    static namespace = "careAsset"
    List resources = new ArrayList()

    def resource = {attrs ->
        if(asset.assetPathExists(src: attrs.src))
            resources.add(attrs.src)
    }

    def layoutJavascript = {
        resources.each { resourceName, index ->
            if (!resourceName.endsWith(".css"))
                out << asset.javascript(name:resourceName)
        }
    }


    def layoutCss = { attrs ->
        resources.eachWithIndex { resourceName, index ->
            if (!resourceName.endsWith(".js"))
                out << asset.stylesheet(name: resourceName)
        }
    }


}