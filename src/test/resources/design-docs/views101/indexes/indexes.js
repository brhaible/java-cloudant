{
    "animals": {
        "index": "function(doc) { index(\"default\", doc._id); if(doc.min_length) {   index(\"min_length\", doc.min_length, {\"store\": \"yes\",\"facet\": true});  } if(doc.diet){   index(\"diet\", doc.diet, {\"store\": \"yes\",\"facet\": true});  }  if (doc.latin_name){    index(\"latin_name\", doc.latin_name, {\"store\": \"yes\"}); }  if (doc['class']){    index(\"class\", doc['class'], {\"store\": \"yes\",\"facet\": true});  }}"
    }
}