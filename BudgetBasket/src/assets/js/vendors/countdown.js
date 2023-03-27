$("[data-countdown]").each(function () {
  var n = $(this),
    s = $(this).data("countdown");
  n.countdown(s, function (n) {
    $(this).html(
      n.strftime(
        '<span class="countdown-section"><span class="countdown-amount hover-up">%D</span><span class="countdown-period"> days </span></span><span class="countdown-section"><span class="countdown-amount hover-up">%H</span><span class="countdown-period"> hours </span></span><span class="countdown-section"><span class="countdown-amount hover-up">%M</span><span class="countdown-period"> mins </span></span><span class="countdown-section"><span class="countdown-amount hover-up">%S</span><span class="countdown-period"> sec </span></span>'
      )
    );
  });
});
