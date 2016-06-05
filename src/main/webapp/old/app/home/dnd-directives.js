var app = angular.module('home');

app.directive('draggable', function() {
	return {
        restrict: "A",
        link: function(scope, element, attributes, ctlr) {
            element.attr("draggable", true);
 
            element.bind("dragstart", function(eventObject) {
            	eventObject.dataTransfer.setData("text", attributes.vmid);
            });
        }
    };
});


app.directive('droppable', function() {
    return {
        restrict: "A",
        link: function (scope, element, attributes, ctlr) {
 
            element.bind("dragover", function(eventObject){
                eventObject.preventDefault();
            });
 
            element.bind("drop", function(eventObject) {
            	scope.openRelevantProtectionModal(eventObject.dataTransfer.getData("text"), attributes.cgid);
                eventObject.preventDefault();
            });
        }
    };
});