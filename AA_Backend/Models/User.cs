using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;

namespace AA_Backend.Models
{
    public class User : IdentityUser
    {
        public virtual List<Character>? Characters { get; set; } = null!;
    }
}
