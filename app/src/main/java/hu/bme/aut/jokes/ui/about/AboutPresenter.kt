package hu.bme.aut.jokes.ui.about

import co.zsmb.rainbowcake.withIOContext
import hu.bme.aut.jokes.domain.JokesInteractor
import javax.inject.Inject

class AboutPresenter @Inject constructor(
    private val jokesInteractor: JokesInteractor
) {

    suspend fun getAboutInfo(): String = withIOContext {
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Justo laoreet sit amet cursus sit amet dictum sit. Nullam ac tortor vitae purus faucibus ornare. Suspendisse ultrices gravida dictum fusce ut placerat orci nulla. Feugiat pretium nibh ipsum consequat. Egestas sed tempus urna et pharetra pharetra massa massa. Phasellus faucibus scelerisque eleifend donec pretium vulputate sapien. Ullamcorper a lacus vestibulum sed arcu non. A cras semper auctor neque. Risus nec feugiat in fermentum posuere urna nec. Tortor vitae purus faucibus ornare suspendisse sed. Tincidunt dui ut ornare lectus sit amet est. Libero nunc consequat interdum varius sit amet mattis vulputate. Elementum nibh tellus molestie nunc non. Elit ut aliquam purus sit. Odio aenean sed adipiscing diam donec adipiscing tristique risus nec. Viverra tellus in hac habitasse platea dictumst vestibulum rhoncus. Nunc non blandit massa enim nec dui nunc mattis. Volutpat consequat mauris nunc congue nisi vitae.\n" +
                "\n" +
                "Vulputate mi sit amet mauris. Senectus et netus et malesuada fames ac turpis. Ut aliquam purus sit amet luctus venenatis lectus. Nunc aliquet bibendum enim facilisis gravida neque convallis. Mauris in aliquam sem fringilla ut morbi tincidunt augue interdum. Tellus molestie nunc non blandit massa enim nec dui. Tincidunt nunc pulvinar sapien et ligula ullamcorper malesuada. Pulvinar pellentesque habitant morbi tristique senectus et netus et. Odio ut enim blandit volutpat maecenas. Massa sapien faucibus et molestie ac feugiat sed. Rutrum quisque non tellus orci ac. Convallis tellus id interdum velit laoreet id donec ultrices tincidunt. Viverra maecenas accumsan lacus vel facilisis volutpat est. Scelerisque varius morbi enim nunc faucibus a pellentesque sit. Malesuada proin libero nunc consequat interdum varius. Amet consectetur adipiscing elit ut aliquam purus sit amet. Quam vulputate dignissim suspendisse in est ante in nibh mauris. Quam vulputate dignissim suspendisse in est. Pellentesque elit eget gravida cum sociis natoque penatibus.\n" +
                "\n" +
                "Turpis massa sed elementum tempus. Dui id ornare arcu odio ut sem nulla pharetra. Eleifend mi in nulla posuere sollicitudin aliquam ultrices. Vulputate dignissim suspendisse in est ante. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim. Et pharetra pharetra massa massa ultricies mi quis hendrerit dolor. Commodo ullamcorper a lacus vestibulum. Purus in mollis nunc sed id. Pharetra sit amet aliquam id. Nec tincidunt praesent semper feugiat nibh.\n" +
                "\n" +
                "Nulla aliquet porttitor lacus luctus accumsan tortor posuere. Elementum tempus egestas sed sed risus pretium. Sagittis aliquam malesuada bibendum arcu vitae elementum curabitur. Volutpat lacus laoreet non curabitur gravida. Varius morbi enim nunc faucibus a pellentesque sit amet porttitor. Cursus in hac habitasse platea. Mauris sit amet massa vitae tortor condimentum lacinia quis vel. Massa ultricies mi quis hendrerit. Varius duis at consectetur lorem donec massa. Quis hendrerit dolor magna eget est lorem. Lacus sed turpis tincidunt id aliquet risus feugiat in ante. Nibh venenatis cras sed felis eget velit aliquet sagittis id. Proin libero nunc consequat interdum varius sit amet mattis. Amet facilisis magna etiam tempor orci eu lobortis elementum. Pretium nibh ipsum consequat nisl vel pretium lectus quam id. Arcu cursus vitae congue mauris rhoncus. Purus in mollis nunc sed id semper risus in. Et egestas quis ipsum suspendisse ultrices. In hendrerit gravida rutrum quisque non tellus orci. Vitae tortor condimentum lacinia quis vel eros.\n" +
                "\n" +
                "Vel fringilla est ullamcorper eget nulla facilisi etiam. Eu scelerisque felis imperdiet proin fermentum leo vel orci. Id volutpat lacus laoreet non curabitur gravida arcu. Mauris pharetra et ultrices neque ornare aenean euismod elementum. Mauris a diam maecenas sed enim ut. Vestibulum morbi blandit cursus risus. Sit amet mattis vulputate enim nulla aliquet porttitor lacus luctus. Adipiscing elit duis tristique sollicitudin nibh sit amet commodo nulla. Rutrum tellus pellentesque eu tincidunt tortor aliquam nulla. Feugiat in ante metus dictum at tempor commodo ullamcorper a. Tristique et egestas quis ipsum suspendisse ultrices gravida. Facilisi etiam dignissim diam quis enim lobortis scelerisque fermentum dui."
    }

}