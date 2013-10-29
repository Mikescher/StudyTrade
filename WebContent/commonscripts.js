function shakeContentBox(box) {
	var s = $(box);
	s.effect("shake", {
		times : 3
	}, 500);
}